package ezooma.customer.com.ezooma.interfaces;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClick(View view, T object, int position);
}


