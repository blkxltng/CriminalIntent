package com.blkxltng.criminalintent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by firej on 9/26/2017.
 */

public class ImageDialogFragment extends DialogFragment {

    private static final String ARG_IMAGE_FILE = "imageFile";

    private ImageView mImageView;
    private File mImageFile;
    private Button mButton;

    public static ImageDialogFragment newInstance(File imageFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_IMAGE_FILE, imageFile);

        ImageDialogFragment fragment = new ImageDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mImageFile = (File) getArguments().getSerializable(ARG_IMAGE_FILE);

        View view = inflater.inflate(R.layout.dialog_image, container, false);

        mImageView = (ImageView) view.findViewById(R.id.dialog_imageView);

        if (mImageFile == null || !mImageFile.exists()) {
            mImageView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mImageFile.getPath(), getActivity());
            mImageView.setImageBitmap(bitmap);
        }

        mButton = (Button) view.findViewById(R.id.dialog_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }
}
