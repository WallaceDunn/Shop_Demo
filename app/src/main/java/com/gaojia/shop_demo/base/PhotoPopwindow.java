package com.gaojia.shop_demo.base;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gaojia.shop_demo.R;

/**
 * Created by Administrator on 2017/3/28.
 */
public class PhotoPopwindow extends PopupWindow implements View.OnClickListener{

    private Context mContext;

    private Handler mHandler;

    public PhotoPopwindow(Context mContext, Handler handler) {
        this.mContext = mContext;
        this.mHandler = handler;
        View view = LayoutInflater.from(mContext).inflate(R.layout.popwindow_takephoto, new LinearLayout(mContext), false);
        setContentView(view);
        //设置点击事件
        TextView btnTakePhoto = (TextView) view.findViewById(R.id.btnTakePhoto);
        TextView btnChooseFromAlbum = (TextView) view.findViewById(R.id.btnChooseFromAlbum);
        TextView btnCancle = (TextView) view.findViewById(R.id.btnCancle);
        btnTakePhoto.setOnClickListener(this);
        btnChooseFromAlbum.setOnClickListener(this);
        btnCancle.setOnClickListener(this);
        //设置宽高
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

        setBackgroundDrawable(new BitmapDrawable());
        //设置外部点击消失
        setOutsideTouchable(true);
        setFocusable(true);
        //设置动画
        setAnimationStyle(R.style.take_photo_anim);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTakePhoto:
                mHandler.sendEmptyMessage(110);
                break;
            case R.id.btnChooseFromAlbum:
                mHandler.sendEmptyMessage(111);
                break;
            case R.id.btnCancle:
                this.dismiss();
                break;
            default:
                break;
        }
    }

}

