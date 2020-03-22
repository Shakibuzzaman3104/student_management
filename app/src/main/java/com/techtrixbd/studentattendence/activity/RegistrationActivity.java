package com.techtrixbd.studentattendence.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.techtrixbd.studentattendence.R;
import com.techtrixbd.studentattendence.databinding.ActivityStartBinding;
import com.techtrixbd.studentattendence.model.ModelStudent;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.techtrixbd.studentattendence.util.Util.isValidEmail;
import static com.techtrixbd.studentattendence.util.Util.isValidID;
import static com.techtrixbd.studentattendence.util.Util.isValidName;
import static com.techtrixbd.studentattendence.util.Util.isValidSection;


public class RegistrationActivity extends BaseActivity {

    Observable<String> section;
    Observable<String> email;
    Observable<String> name;
    Observable<String> id;

    Observable<Boolean> observable;

    ActivityStartBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initObservables();

        binding.login.setOnClickListener(v->{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });

        binding.submit.setOnClickListener(v->{
            showDialog();
        });

    }

    private void showDialog() {
        new TTFancyGifDialog.Builder(RegistrationActivity.this)
                .setTitle("Are you sure ?")
                .setMessage("Recheck all the information again. MisInformation can lead to absent in the class.")
                .setPositiveBtnText("Continue")
                .setPositiveBtnBackground("#22b573")
                .setNegativeBtnText("Recheck")
                .setNegativeBtnBackground("#c1272d")
                .setGifResource(R.drawable.giphy)      //pass your gif, png or jpg
                .isCancellable(true)
                .OnPositiveClicked(() -> {submitData();})
                .OnNegativeClicked(() -> {})
                .build();
    }

    private void submitData() {

        ModelStudent modelStudent = new ModelStudent(binding.etId.getText().toString().trim(),binding.etName.getText().toString().trim(),
                binding.etEmail.getText().toString().trim(),binding.etSection.getText().toString().trim());

        apiInterface.register(modelStudent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(modelResponse-> {
                    if(modelResponse.getSuccess())
                    {
                        sharedPreference.setIsFirstBoot(false);
                        sharedPreference.setID(binding.etId.getText().toString());
                        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this,MainActivity.class));
                        finish();
                    }
                    else
                        Toast.makeText(this, ""+modelResponse.getMessage(), Toast.LENGTH_SHORT).show();
                },t->{
                    Log.d("MyError", ""+t.getMessage());
                });

    }


    private void initObservables() {
        email = RxTextView.textChanges(binding.etEmail).skip(1).map(CharSequence::toString);
        name = RxTextView.textChanges(binding.etName).skip(1).map(CharSequence::toString);
        id = RxTextView.textChanges(binding.etId).skip(1).map(CharSequence::toString);
        section = RxTextView.textChanges(binding.etSection).skip(1).map(CharSequence::toString);

        loginButton(false);

        observable = Observable.combineLatest(name,email,id,section,this::isValidForm);
        observable.subscribe(this::loginButton);

    }

    public void loginButton(boolean valid){
        if (valid) {
            binding.submit.setClickable(true);
            binding.submit.setEnabled(true);
        }

        else
        {
            binding.submit.setClickable(false);
            binding.submit.setEnabled(false);
        }
    }


    private boolean isValidForm(String name,String email,String id,String section) {

        if (!isValidEmail(email))
            binding.etEmail.setError("Invalid Email");

        if (!isValidName(name))
            binding.etName.setError("Invalid Name");

        if (!isValidID(id))
            binding.etId.setError("Invalid id");

        if (!isValidSection(section))
            binding.etSection.setError("Invalid section");


        return isValidEmail(email) && isValidName(name) && isValidID(id) && isValidSection(section);
    }


}
