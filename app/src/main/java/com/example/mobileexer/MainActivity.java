package com.example.mobileexer;


import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
	private SeekBar rücken;
	private EditText rücken1;
	private SeekBar sitzt;
	private EditText sitzt1;
	private SeekBar fuss;
	private EditText fuss1;
	private Button liegen;
	private Button sitzen;
	private Button zerogravity;
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
	public void onSensorChanged(SensorEvent sensorEvent) {
		rücken.setProgress(rücken.getProgress());
		sitzt.setProgress(sitzt.getProgress());
		fuss.setProgress(fuss.getProgress());
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int i) {

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		meditationList = findViewById(R.id.meditation_list);
		rücken = (SeekBar)findViewById(R.id.rücken_Seekbar);
		rücken1 = (EditText) findViewById(R.id.rücken_Edit_text);
		rücken1.setText("" + rücken.getProgress());

		rücken.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
				rücken1.setText("" + progress);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		sitzt = (SeekBar)findViewById(R.id.sitzt_Seek_Bar);
		sitzt1 = (EditText)findViewById(R.id.Sitzt_Edit_Text);
		sitzt1.setText("" + sitzt.getProgress());

		sitzt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
				sitzt1.setText(""+progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		fuss = (SeekBar)findViewById(R.id.fuss_Seek_Bar);
		fuss1 = (EditText)findViewById(R.id.fuss_Edit_Text);
		fuss1.setText("" + fuss.getProgress());

		fuss.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
				fuss1.setText(""+progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		rücken1.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				String in = rücken1.getText().toString();
				int grad = Integer.parseInt(in);
				rücken.setProgress(grad);
				if (grad < 0){
					rücken1.setText(0);
				}
				int  limit = 0;
				if (grad > 87){
					rücken1.setText((""+limit));
				}
			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});

		sitzt1.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				String in = sitzt1.getText().toString();
				int grad = Integer.parseInt(in);
				sitzt.setProgress(grad);
				int  limit = 0;
				if (grad > 30){
					sitzt1.setText((""+limit));
				}

			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});

		fuss1.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
				String in = fuss1.getText().toString();
				int grad = Integer.parseInt(in);
				fuss.setProgress(grad);
				int  limit = 0;
				if (grad > 90){
					fuss1.setText((""+limit));
				}

			}

			@Override
			public void afterTextChanged(Editable editable) {

			}
		});


		liegen = (Button)findViewById(R.id.buttonRücken);
		sitzen = (Button)findViewById(R.id.buttonSitzt);
		zerogravity = (Button)findViewById(R.id.buttonfuss);

		liegen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rücken.setProgress(0);
				sitzt.setProgress(0);
				fuss.setProgress(90);
			}
		});

		sitzen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rücken.setProgress(87);
				sitzt.setProgress(0);
				fuss.setProgress(0);
			}
		});
		zerogravity.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rücken.setProgress(60);
				sitzt.setProgress(25);
				fuss.setProgress(25);
			}
		});


		Adapter adapter = new Adapter(this, soundPic, soundName);
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