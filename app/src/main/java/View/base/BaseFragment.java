package View.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lms.databinding.ActivityMainBinding;
import com.example.lms.databinding.FragmentDataBinding;

public abstract class BaseFragment extends Fragment {
    protected View contentView;
    protected FragmentDataBinding binding;

    protected abstract int getLayoutId();
    protected abstract void initViews();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(getLayoutId(), container, false);
        binding = FragmentDataBinding.inflate(inflater);
        initViews();
        return contentView;
    }
}
