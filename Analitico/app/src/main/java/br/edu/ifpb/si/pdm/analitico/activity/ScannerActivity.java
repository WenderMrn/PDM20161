package br.edu.ifpb.si.pdm.analitico.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import br.edu.ifpb.si.pdm.analitico.R;
import br.edu.ifpb.si.pdm.analitico.service.FaceDetectorService;

public class ScannerActivity extends AppCompatActivity {

    private Intent faceDetectService;
    private FaceDetectorReceiver faceDetectorReceiver;
    private IntentFilter intentFilterFaceService;
    private EditText etUrl;
    private Button btnAnalisar;
    private Button btnProcurar;
    private ImageButton btnX;
    private LinearLayout contentLayout;

    private View mLoadingView;
    private int mShortAnimationDuration;

    public ScannerActivity() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.faceDetectorReceiver, this.intentFilterFaceService);

    }

    @Override
    protected void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.faceDetectorReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        this.loadComponents();
        this.addListener();
        this.faceDetectorReceiver = new FaceDetectorReceiver();
        this.intentFilterFaceService = new IntentFilter();
        this.intentFilterFaceService.addAction("FaceDetectorService");

        this.mLoadingView = findViewById(R.id.loading_spinner);
        this.mLoadingView.setVisibility(View.GONE);

        // Retrieve and cache the system's default "short" animation time.
        this.mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);
    }

    private void addListener(){
        View.OnClickListener onClickListener = new OnClick();
        this.btnProcurar.setOnClickListener(onClickListener);
        this.btnAnalisar.setOnClickListener(onClickListener);
        this.btnX.setOnClickListener(onClickListener);
    }

    private void loadComponents(){
        this.etUrl = (EditText) findViewById(R.id.etUrl);
        this.btnAnalisar = (Button) findViewById(R.id.btnAnalisar);
        this.btnProcurar = (Button) findViewById(R.id.btnProcurar);
        this.btnX = (ImageButton) findViewById(R.id.btnX);
        this.contentLayout = (LinearLayout) findViewById(R.id.contentLayout);
    }

    private class FaceDetectorReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            stopService(ScannerActivity.this.faceDetectService);
            ScannerActivity.this.mLoadingView.setVisibility(View.GONE);
            ScannerActivity.this.contentLayout.setVisibility(View.VISIBLE);
            Intent it = new Intent();
            if(intent.getIntExtra("error",-1)==0){
                Bundle extras = intent.getExtras();
                it.putExtras(extras);
                ScannerActivity.this.setResult(RESULT_OK,it);
                finish();
            }else if(intent.getIntExtra("error",-1)==2){
                String message = intent.getStringExtra("message") != null?intent.getStringExtra("message"):"";
                Toast.makeText(context,"O servidor respondeu com erro: "+message, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"Verifique sua conexão com a internet!" , Toast.LENGTH_SHORT).show();
            }

        }
    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(v.equals(ScannerActivity.this.btnAnalisar)){
                ScannerActivity.this.mLoadingView.setVisibility(View.VISIBLE);
                ScannerActivity.this.faceDetectService = new Intent(ScannerActivity.this, FaceDetectorService.class);
                ScannerActivity.this.faceDetectService.putExtra("URL",ScannerActivity.this.etUrl.getText().toString());
                ScannerActivity.this.mLoadingView.setVisibility(View.VISIBLE);
                ScannerActivity.this.contentLayout.setVisibility(View.INVISIBLE);
                startService(ScannerActivity.this.faceDetectService);
            }else if(v.equals(ScannerActivity.this.btnX)){
                ScannerActivity.this.etUrl.setText("");
            }else if(v.equals(ScannerActivity.this.btnProcurar)){
                Uri u = Uri.parse("http://www.google.com");
                Intent it = new Intent(Intent.ACTION_VIEW,u);
                startActivity(it);
            }
        }
    }
}
