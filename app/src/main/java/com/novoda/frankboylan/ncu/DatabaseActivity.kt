package com.novoda.frankboylan.ncu

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.facebook.stetho.Stetho
import com.novoda.frankboylan.ncu.R.id.btn_save
import com.novoda.frankboylan.ncu.datamodel.DepartmentDatabase
import com.novoda.frankboylan.ncu.datamodel.NodeMap
import com.novoda.frankboylan.ncu.datamodel.NodeRelationship
import kotlinx.android.synthetic.main.activity_database.*

class DatabaseActivity : AppCompatActivity() {

    private var db: DepartmentDatabase? = null
    private var nodeMap: NodeMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        db = DepartmentDatabase.getInstance(this)

//        if (db == null) {
//            db = Room.databaseBuilder(applicationContext,
//                    DepartmentDatabase::class.java, "NodeMap.db")
//                    .allowMainThreadQueries() // ToDo: Remove and use Kotlin Coroutines
//                    .build()
//        }
        db!!.metadataDao().insert(metadata = com.novoda.frankboylan.ncu.datamodel.Metadata("1","",0,""))

        Stetho.initializeWithDefaults(this)

        val fileReader = FileReader()
        val assetManager: AssetManager = this.assets
        val fileValidator = FileValidator()
        val nodeMapCreator = NodeMapCreator()

        val uncleanJson = fileReader.readFile(assetManager, "dataset_main.txt")
        val cleanJson = fileValidator.clean(uncleanJson)

        nodeMap = nodeMapCreator.createFromJsonString(cleanJson)

        btn_save.setOnClickListener {
            if (db!!.metadataDao().getMetadata().departmentCode != nodeMap!!.metadata.departmentCode) {
                saveJourneyProgress()
            }
            val intent = Intent(this, TreeActivity::class.java)
            startActivity(intent)
        }
    }

    // Temporary method that adds dataset_main.txt to the new Room database
    private fun saveJourneyProgress() {
        Thread {

            val layerList = nodeMap!!.layers
            val metadata = nodeMap!!.metadata

            db!!.metadataDao().insert(metadata)
            
            layerList.indices.forEach { i ->
                val nodeList = layerList[i].nodeList

                nodeList.indices.forEach { x ->
                    val currentNode = nodeList[x]
                    currentNode.layerNumber = i

                    Log.d("FB8159-node", x.toString() + ": " + currentNode.id + " " + currentNode.layerNumber)

                    db!!.nodeDao().insert(currentNode)

                    val childList = nodeList[x].childrenList

                    childList.indices.forEach { c ->
                        Log.d("FB8159-relationship", c.toString() + ": " + currentNode.id + "-" + childList[c].id)

                        db!!.nodeRelationshipDao().insertRelationship(NodeRelationship(0, currentNode.id, childList[c].id))
                    }
                }
            }
        }.start()
    }
}
