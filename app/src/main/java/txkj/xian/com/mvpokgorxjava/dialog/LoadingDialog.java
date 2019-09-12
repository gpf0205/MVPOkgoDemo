package txkj.xian.com.mvpokgorxjava.dialog;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;

import txkj.xian.com.mvpokgorxjava.R;

/**
 * Created by AnOnYm on 2019/1/9.
 */

public class LoadingDialog extends BaseDialog<LoadingDialog> {

    private final String info;
    private TextView tvInfo;

    public LoadingDialog(Context context, String info) {
        super(context);
        this.info = info;
    }

    @Override
    public View onCreateView() {
        widthScale(0.35f);
//        dimEnabled(false); // 去掉背景遮罩层
        View inflate = View.inflate(mContext, R.layout.loading_dialog, null);
        tvInfo = inflate.findViewById(R.id.tvInfo);
        tvInfo.setText(info);
        inflate.setBackgroundDrawable(
                CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));
        return inflate;
    }

    public void setTitle(String str){
        tvInfo.setText(str);
    }

    @Override
    public void setUiBeforShow() {

    }
}

