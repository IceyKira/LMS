package View.base;

import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Model.base.BaseModel;

public abstract class BaseAdapter<T, VH extends BaseViewHolder, BM extends BaseModel> extends RecyclerView.Adapter<VH> {

    protected ArrayList<BM> mData = new ArrayList<>();

    protected SparseIntArray itemTypes = new SparseIntArray();

    //构造体及传递Model
    public BaseAdapter(ArrayList<BM> data) {
        if(data == null) return;
        mData = data;
        initItemType();
    }

    public void addData(BM data) {
        if(data == null) return;
        mData.add(data);
    }

    public void addAll(ArrayList<BM> data) {
        if(data == null) return;
        mData.addAll(data);
    }

    protected void addItemType(int viewType, @LayoutRes int layoutResId) {
        itemTypes.put(viewType, layoutResId);
    }

    protected abstract void initItemType();

    //重写
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutResId = itemTypes.get(viewType);
        VH viewHolder = (VH) new BaseViewHolder( LayoutInflater.from( parent.getContext() ).inflate(layoutResId, parent, false) );
        bindViewItemClickListener(viewHolder);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(this.mData == null) return 0;
        BM bm = this.mData.get(position);
        if (bm == null) return 0;
        return bm.getItemType().getId();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) { //绑定数据
        BM data = mData.get(position);
        convertData(holder, data, position);
    }
    protected abstract void convertData(VH holder, BM bm, int position);

    @Override
    public int getItemCount() {
        if(mData == null) return 0;
        return mData.size();
    }

    protected OnRecyclerItemListener<BM> onRecyclerItemListener;
    //监听点击事件
    public interface OnRecyclerItemListener <BM extends BaseModel> {
        void OnRecyclerItemClick(int position, BM bm);
    }

    protected void setOnRecyclerItemListener(OnRecyclerItemListener<BM> onRecyclerItemListener) {
        this.onRecyclerItemListener = onRecyclerItemListener;
    }

    private void bindViewItemClickListener(VH viewHolder) {
        if(onRecyclerItemListener == null) return;
        viewHolder.itemView.setOnClickListener(view -> {
            int position = viewHolder.getAdapterPosition();
            BM bm = getDataById(position);
            onRecyclerItemListener.OnRecyclerItemClick(position, bm);
        });
    }

    private BM getDataById(int position) {
        if(position == RecyclerView.NO_POSITION) return null;
        return mData.get(position);
    }

}
