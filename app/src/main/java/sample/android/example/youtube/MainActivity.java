package sample.android.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyDzNCeaPG5nAQdY91-Itd4zbkvLdGe3NU0";

    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYouTubePlayerView = findViewById(R.id.YouTube_view);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {

            //初期化に成功した時の処理
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //再生したいYouTubeのIDを入力
                youTubePlayer.loadVideo("wjtKaz1k9sA");

            }

            //初期化に失敗した場合の処理
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        //APIキーを読み込んでloadVideoを実行するためにmOnInitializedListenerを読込み
        mYouTubePlayerView.initialize(API_KEY,mOnInitializedListener);

    }
}
