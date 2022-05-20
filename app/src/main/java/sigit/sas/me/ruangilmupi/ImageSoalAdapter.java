package sigit.sas.me.ruangilmupi;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageSoalAdapter extends ListAdapter<Drawable, ImageSoalAdapter.ViewHolder> {

    protected ImageSoalAdapter() {
        super(IMAGE_SOAL_ITEM_CALLBACK);
    }

    @NonNull
    @Override
    public ImageSoalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_image_soal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSoalAdapter.ViewHolder viewHolder, int i) {
        Drawable image = getItem(i);
        if (image != null) {
            viewHolder.imageView.setImageDrawable(image);
            viewHolder.imageView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.imageView.setVisibility(View.GONE);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_soal_recycler);
        }
    }

    public static final DiffUtil.ItemCallback<Drawable> IMAGE_SOAL_ITEM_CALLBACK = new DiffUtil.ItemCallback<Drawable>() {
        @Override
        public boolean areItemsTheSame(@NonNull Drawable oldItem, @NonNull Drawable newItem) {
            return oldItem.equals(newItem);
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Drawable oldItem, @NonNull Drawable newItem) {
            return oldItem.hashCode() == newItem.hashCode();
        }
    };
}
