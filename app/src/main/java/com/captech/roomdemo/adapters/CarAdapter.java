package com.captech.roomdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.captech.roomdemo.R;
import com.captech.roomdemo.localstorage.room.Entity.Car;
import com.captech.roomdemo.utils.Constant;
import com.captech.roomdemo.utils.Utils;

import java.util.List;

/**
 * @author acampbell
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<Car> groupCars;
    private ICarAdapter callback;
    private Context mContext;

    public CarAdapter(Context context, List<Car> groupCars, ICarAdapter iContactAdapter) {
        this.groupCars = groupCars;
        this.callback = iContactAdapter;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Car contact = groupCars.get(position);
        // holder.itemContact.setBackgroundColor(Utils.getArrayColors(mContext)[new Random().nextInt(Utils.getArrayColors(mContext).length-1)]);
        holder.firstname.setText(contact.getFirstName());
        holder.avatar.setImageBitmap(Utils.convertToBitmap(contact.getAvatar()));
        holder.delete.setImageResource(R.drawable.delete);
        holder.delete.setTag("delete.png");
        final boolean[] isClick = {false};
        holder.itemContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick[0]) {
                    holder.delete.setImageResource(R.drawable.delete);
                    holder.delete.setTag("delete.png");
                } else {
                    holder.delete.setImageResource(R.drawable.update);
                    holder.delete.setTag("update.png");
                }
                isClick[0] = !isClick[0];
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals(holder.delete.getTag()+ Constant.EMPTY_STRING, "delete.png")) {
                    callback.deleteContact(contact);
                } else {
                    callback.editContact(contact);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupCars.size();
    }

    public void updateListOfContact(List<Contact> grouContacts) {
        this.groupCars = grouContacts;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView firstname;
        ImageView avatar, delete;
        RelativeLayout itemContact;

        ViewHolder(View itemView) {
            super(itemView);
            firstname = (TextView) itemView.findViewById(R.id.firstname);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            itemContact = (RelativeLayout) itemView.findViewById(R.id.item_contact);
            delete = (ImageView) itemView.findViewById(R.id.delete);
        }
    }

    public interface ICarAdapter {
        void editContact(Contact contact);
        void deleteContact(Contact contact);
    }
}
