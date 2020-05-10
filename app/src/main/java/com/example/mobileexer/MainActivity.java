package com.example.mobileexer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

	private MediaPlayer mMediaPlayer;
	/**
	 * Handles audio focus when playing a sound file
	 */

	/**
	 * This listener gets triggered when the {@link MediaPlayer} has completed
	 * playing the audio file.
	 */
	private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mediaPlayer) {
			// Now that the sound file has finished playing, release the media player resources.
			releaseMediaPlayer();
		}
	};


	ListView meditationList;

	String[] soundName = {"forest", "rain", "wind", "birds", "beach", "forest", "rain", "wind", "birds", "beach"};
	int[] soundPic = {R.drawable.forest, R.drawable.rain, R.drawable.wind, R.drawable.birds, R.drawable.beach, R.drawable.forest, R.drawable.rain, R.drawable.wind, R.drawable.birds, R.drawable.beach};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		meditationList = findViewById(R.id.meditation_list);



		Adapter adapter = new Adapter( this, soundPic, soundName);
		meditationList.setAdapter(adapter);



//		meditationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//				// Release the media player if it currently exists because we are about to
//				// play a different sound file
//				releaseMediaPlayer();
//
//				// Get the {@link Word} object at the given position the user clicked on
//				 meditationList.getPositionForView(meditationList);
//
//					mMediaPlayer = MediaPlayer.create(this, word.getAudioResourceId());
//
//					// Start the audio file
//					mMediaPlayer.start();
//
//					// Setup a listener on the media player, so that we can stop and release the
//					// media player once the sound has finished playing.
//					mMediaPlayer.setOnCompletionListener(mCompletionListener);
//			}
//		});


	}

	private void releaseMediaPlayer() {
		// If the media player is not null, then it may be currently playing a sound.
		if (mMediaPlayer != null) {
			// Regardless of the current state of the media player, release its resources
			// because we no longer need it.
			mMediaPlayer.release();

			// Set the media player back to null. For our code, we've decided that
			// setting the media player to null is an easy way to tell that the media player
			// is not configured to play an audio file at the moment.
			mMediaPlayer = null;

			// Regardless of whether or not we were granted audio focus, abandon it. This also
			// unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
		}
	}

}
