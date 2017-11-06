package com.captech.roomdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.captech.roomdemo.R;
import com.captech.roomdemo.domain.Contact;
import com.captech.roomdemo.utils.Constant;
import com.captech.roomdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acampbell
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> grouContacts = new ArrayList<>();
    private IContactAdapter callback;
    private Context mContext;

    public ContactAdapter(Context context, List<Contact> grouContacts, IContactAdapter iContactAdapter) {
        this.grouContacts = grouContacts;
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
        final Contact contact = grouContacts.get(position);
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
        return grouContacts.size();
    }

    public void updateListOfContact(List<Contact> grouContacts) {
        this.grouContacts = grouContacts;
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

    public interface IContactAdapter {
        void editContact(Contact contact);
        void deleteContact(Contact contact);
    }
}
