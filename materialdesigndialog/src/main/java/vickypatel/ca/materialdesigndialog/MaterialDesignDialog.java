package vickypatel.ca.materialdesigndialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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

    public interface OnPositiveActionListener {
        public void onPositiveAction();
    }
    public interface OnNegativeActionListener {
        public void onNegativeAction();
    }

    public MaterialDesignDialog(Context context){
        this.context = context;
    }

    public void initializeSimpleDialog(
            String dialogTitle, String dialogContent, String positiveActionText, String negativeActionText,
            final OnPositiveActionListener onPositiveActionListener,
            final OnNegativeActionListener onNegativeActionListener) {

        //Custom dialog
        final Dialog dialog = new Dialog(context);
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
        txtTitle.setText(dialogTitle);

        LinearLayout contentLayout = (LinearLayout) dialog.findViewById(R.id.layout_dialog_content);
        TextView txtMessage = (TextView) dialog.findViewById(R.id.txt_dialog_message);
        txtMessage.setText(dialogContent);

        Button btnOk = (Button) dialog.findViewById(R.id.btn_ok);
        btnOk.setText(positiveActionText);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                onPositiveActionListener.onPositiveAction();
            }
        });

        Button btnCancel = (Button) dialog.findViewById(R.id.btn_cancel);
        btnCancel.setText(negativeActionText);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the dialog
                dialog.dismiss();
                onNegativeActionListener.onNegativeAction();
            }
        });

        dialog.show();
    }
}
