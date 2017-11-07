package com.captech.myapp.ui.activities.Video;

import android.os.Bundle;
import android.widget.Toast;

import com.captech.myapp.R;
import com.captech.myapp.ui.activities.Video.interfaces.IVideoView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lorence on 07/11/2017.
 * @Run: https://developer.android.com/training/permissions/requesting.html
 * => Done
 *
 * @Run: https://developers.google.com/youtube/android/player/downloads/
 * => Get YouTubeAPI : Done
 *
 * @Run: https://console.developers.google.com/apis/dashboard?project=versionone-ec404&duration=PT1H&creatingProject=true
 * => Get API_YOUTUBE
 */

public class VideoView extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, IVideoView{

    @BindView(R.id.youtubePlayerView)
    public YouTubePlayerView mPlayerView;

    private static String API_KEY = "AIzaSyAs4UrkQKzjY2XMyTUVBEobdZSU-7BfN9s";
    private static String VIDEO_ID = "bM7SZ5SBzyY";
    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;
    private Unbinder mUnbinder;

    @Override
    public int getLayoutResId() {
        return R.layout.video_screen;
    }

    @Override
    public void activityCreated() {
        initAttributes();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
        initAttributes();
        /** Initializing YouTube Player View **/
        mPlayerView.initialize(API_KEY, this);
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    private void initAttributes() {
        initStatusPlayVideo();
        updateStatusPlayVideo();
    }

    private void initStatusPlayVideo() {
        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {

            }

            @Override
            public void onPaused() {

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };
    }

    private void updateStatusPlayVideo() {
        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {

            }

            @Override
            public void onVideoStarted() {

            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        };
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        /* add listeners to YoutubePlayer instance */
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        /* Start buffering */
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failure to Initialize!", Toast.LENGTH_SHORT).show();
    }
}
