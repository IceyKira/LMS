package View.base;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views = new SparseArray();

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    //通过R.id.获取并保存view 其余函数以具体配置控件
    public <T extends View> T getViewOrNull(@IdRes int viewId) {
        View view = views.get(viewId);
        if(view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    //通过传递 viewId 配置 View
    public BaseViewHolder setText(@IdRes int viewId, @StringRes int resId) {
        TextView tv = getViewOrNull(viewId);
        tv.setText(resId);
        return this;
    }

    public BaseViewHolder setText(@IdRes int viewId, String string) {
        TextView tv = getViewOrNull(viewId);
        tv.setText(string);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        TextView tv = getViewOrNull(viewId);
        tv.setTextColor(color);
        return this;
    }

    public BaseViewHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        View view = getViewOrNull(viewId);
        view.setBackgroundColor(color);
        return this;
    }

}

