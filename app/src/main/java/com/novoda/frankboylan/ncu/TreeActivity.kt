package com.novoda.frankboylan.ncu

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup.LayoutParams
import android.widget.ImageView
import android.widget.LinearLayout

class TreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        val node = ImageView(this)
        node.setImageBitmap(drawNode(200, 200))
        node.layoutParams = LayoutParams(200, 200)

        linearLayout.addView(node)

        val node2 = ImageView(this)
        node2.setImageBitmap(drawNode(200, 200))
        node2.layoutParams = LayoutParams(200, 200)

        linearLayout.addView(node2)

        val node3 = ImageView(this)
        node3.setImageBitmap(drawNode(200, 200))
        node3.layoutParams = LayoutParams(200, 200)

        linearLayout.addView(node3)

        setContentView(linearLayout)
    }

    private fun drawNode(posX: Int, posY: Int): Bitmap {
        val bitmap: Bitmap = Bitmap.createBitmap(
                400,
                400,
                Bitmap.Config.ARGB_8888
        )

        val canvas = Canvas(bitmap)

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
        paint.isAntiAlias = true

        val radius = 50f
        val cx = posX + 0f
        val cy = posY + 0f

        canvas.drawCircle(cx, cy, radius, paint)

        return bitmap
    }
}
