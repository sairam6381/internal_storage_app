package com.example.ex_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class SAMPLE @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    override fun onDraw(canvas : Canvas?){
        super.onDraw(canvas)
        val paint :Paint=Paint()
        paint.setColor(Color.YELLOW)
        canvas?.drawPaint (paint)
        paint.setColor(Color.GREEN)
        canvas?.drawLine(0f,0f,100f,100f, paint)

    }

}