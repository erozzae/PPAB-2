package com.example.fragmentexample1updated;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleFragmen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragmen extends Fragment {

    private static final  int Yes =0;
    private static final  int No =1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SimpleFragmen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SimpleFragmen.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragmen newInstance(String param1, String param2) {
        SimpleFragmen fragment = new SimpleFragmen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple, container, false);
        RadioGroup radioGroup = view.findViewById(R.id.radio_btn_fdbck_group);
        TextView questionText = view.findViewById(R.id.question_text);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    RadioButton btn = radioGroup.findViewById(i);
                    int selectedIndex = radioGroup.indexOfChild(btn);

                    switch (selectedIndex){
                        case Yes:
                           questionText.setText(R.string.yes_message);
                            break;

                        case No:
                            questionText.setText(R.string.no_message);
                            break;

                        default:
                            break;
                    }

                }
            });
        // Inflate the layout for this fragment
        return view;
    }
}