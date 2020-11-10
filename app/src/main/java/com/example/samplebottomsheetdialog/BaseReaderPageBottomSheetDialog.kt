package com.example.samplebottomsheetdialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * @author zhanglulu on 2020/10/29.
 * for 阅读页装扮背景弹窗
 */
open class BaseReaderPageBottomSheetDialog: BaseDialogFragment() {


    protected lateinit var ctx: Context

    init {
        gravity = Gravity.BOTTOM
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx  = context
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        ctx = activity
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(ctx, R.style.bottom_sheet_dialog_style)
    }

    override fun onStart() {
        super.onStart()
        applyTheme()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStop() {
        super.onStop()
        //屏蔽 从当前页面跳转后 回来还会展示展示动画
        window?.setWindowAnimations(0)
    }

    private fun applyTheme() {
        if (!isShowing) {
            return
        }
        //设置背景颜色
        val bottomSheetView = dialog?.findViewById(R.id.design_bottom_sheet) as FrameLayout
        val bgDrawable = ctx.resources.getDrawable(R.drawable.bg_top_round_rect_white_16dp)
        bottomSheetView.background = bgDrawable
    }

}