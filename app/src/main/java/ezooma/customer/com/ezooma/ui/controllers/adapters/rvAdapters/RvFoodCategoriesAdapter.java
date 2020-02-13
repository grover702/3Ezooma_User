package ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.interfaces.OnItemClickListener;
import ezooma.customer.com.ezooma.models.CategoriesModel;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class RvFoodCategoriesAdapter extends RecyclerView.Adapter<RvFoodCategoriesAdapter.ViewHolder> {
    private Context mContext;
    private OnItemClickListener<CategoriesModel> mOnItemClickListener;
    private List<CategoriesModel> mList ;
    public RvFoodCategoriesAdapter(Context pContext, List<CategoriesModel> pCategoriesList) {
        mContext = pContext;
        mList = pCategoriesList ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_food_categories, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.OnBind(mList.get(position),   position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RecyclerView mRvSubCategories;
        RvSubCategoriesAdapter mRvSubCategoriesAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRvSubCategories = itemView.findViewById(R.id.rvSubCategories);

            itemView.setOnClickListener(this);
        }

        public void OnBind(CategoriesModel pCategoriesModel, int pPosition) {
            setUpSubCategoriesRv(mRvSubCategories);
            if(pCategoriesModel.isVisibleSubCate()){
                mRvSubCategories.setVisibility(View.VISIBLE);
            }
            else{
                mRvSubCategories.setVisibility(View.GONE);
            }
        }

        private void setUpSubCategoriesRv(RecyclerView mRvSubCategory) {
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mContext, 2) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            mRvSubCategory.setLayoutManager(layoutManager);
            mRvSubCategory.setItemAnimator(new DefaultItemAnimator());
            mRvSubCategoriesAdapter = new RvSubCategoriesAdapter(mContext);
            mRvSubCategory.setAdapter(mRvSubCategoriesAdapter);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, mList.get(getLayoutPosition()), getLayoutPosition());
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener<CategoriesModel> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}
