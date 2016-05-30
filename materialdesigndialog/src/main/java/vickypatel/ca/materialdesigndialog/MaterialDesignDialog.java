package vickypatel.ca.materialdesigndialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by VickyPatel on 2016-05-27.
 */
public class MaterialDesignDialog {

    public Context context;
    Dialog dialog;


    public interface OnActionListener {
        public void onClick();
    }

    public MaterialDesignDialog(Builder builder){
        this.context = builder.context;
        dialog = initializeSimpleDialog(builder);
    }

    public static class Builder{
        protected Context context;
        protected String title;
        protected String content;
        protected String positiveActionText;
        protected String negativeActionText;

        protected OnActionListener onPositiveActionListener;
        protected OnActionListener onNegativeActionListener;

        public Builder(@NonNull Context context){
            this.context = context;
        }

        public Builder title(@NonNull String title){
            this.title = title;
            return this;
        }

        public Builder content(@NonNull String content){
            this.content = content;
            return this;
        }

        public Builder positiveActionText(@NonNull String positiveActionText){
            this.positiveActionText = positiveActionText;
            return this;
        }

        public Builder negativeActionText(@NonNull String negativeActionText){
            this.negativeActionText = negativeActionText;
            return this;
        }

        public Builder onPositiveAction(@NonNull OnActionListener callback){
            this.onPositiveActionListener = callback;
            return this;
        }

        public Builder onNegativeAction(@NonNull OnActionListener callback){
            this.onNegativeActionListener = callback;
            return this;
        }

        @UiThread
        public  void show(){
            new MaterialDesignDialog(this);
        }

    }
    public Dialog initializeSimpleDialog(final Builder builder) {

        dialog = new Dialog(context);

        // hide to default title for Dialog
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // inflate the layout dialog_layout.xml and set it as contentView
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_view, null, false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));

        // Retrieve views from the inflated dialog layout and update their values
        LinearLayout tittleLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_tittle);
        TextView txtTitle = (TextView) dialog.findViewById(R.id.txt_dialog_title);

        LinearLayout contentLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_content);
        TextView txtMessage = (TextView) dialog.findViewById(R.id.txt_dialog_message);

        Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if(builder.onPositiveActionListener != null){
                    builder.onPositiveActionListener.onClick();
                }
            }
        });

        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the dialog
                dialog.dismiss();
                if(builder.onNegativeActionListener != null){
                    builder.onNegativeActionListener.onClick();
                }
            }
        });


        if(builder.title != null){
            txtTitle.setText(builder.title);
        }
        if(builder.content != null){
            txtMessage.setText(builder.content);
        }
        if(builder.positiveActionText != null){
            btnOk.setText(builder.positiveActionText);
        }
        if(builder.negativeActionText != null){
            btnCancel.setText(builder.negativeActionText);
        }

        dialog.show();
        return dialog;
    }
}
