package com.example.atta_ur_rahman.timer;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button btn_5min,btn_10min,btn_15min,btn_20min,btn_25min,btn_30min;

    private ImageView
            iv_5min_pause,iv_5min_reset,iv_5min_play,
            iv_10min_pause,iv_10min_reset,iv_10min_play,
            iv_15min_pause, iv_15min_reset,iv_15min_play,
            iv_20min_pause,iv_20min_reset,iv_20min_play,
            iv_25min_pause,iv_25min_reset,iv_25min_play,
            iv_30min_pause,iv_30min_reset,iv_30min_play;


    int Seconds;

    public int counter,i;




    //Declare a variable to hold count down timer's paused status
    private boolean isPaused = false;
    //Declare a variable to hold count down timer's paused status
    private boolean isCanceled = false;

    //Declare a variable to hold CountDownTimer remaining time
    private long timeRemaining = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_5min = (Button) findViewById(R.id.btn_5min);
        btn_10min = (Button) findViewById(R.id.btn_10min);
        btn_15min = (Button) findViewById(R.id.btn_15min);
        btn_20min = (Button) findViewById(R.id.btn_20min);
        btn_25min = (Button) findViewById(R.id.btn_25min);
        btn_30min = (Button) findViewById(R.id.btn_30min);

        iv_5min_pause = (ImageView) findViewById(R.id.iv_5min_pause);
        iv_5min_play = (ImageView) findViewById(R.id.iv_5min_play);
        iv_5min_reset = (ImageView) findViewById(R.id.iv_5min_reset);
        iv_10min_pause = (ImageView) findViewById(R.id.iv_10min_pause);
        iv_10min_play = (ImageView) findViewById(R.id.iv_10min_play);
        iv_10min_reset = (ImageView) findViewById(R.id.iv_10min_reset);
        iv_15min_pause = (ImageView) findViewById(R.id.iv_15min_pause);
        iv_15min_play = (ImageView) findViewById(R.id.iv_15min_play);
        iv_15min_reset = (ImageView) findViewById(R.id.iv_15min_reset);
        iv_20min_pause = (ImageView) findViewById(R.id.iv_20min_pause);
        iv_20min_play = (ImageView) findViewById(R.id.iv_20min_play);
        iv_20min_reset = (ImageView) findViewById(R.id.iv_20min_reset);
        iv_25min_pause = (ImageView) findViewById(R.id.iv_25min_pause);
        iv_25min_play = (ImageView) findViewById(R.id.iv_25min_play);
        iv_25min_reset = (ImageView) findViewById(R.id.iv_25min_reset);
        iv_30min_pause = (ImageView) findViewById(R.id.iv_30min_pause);
        iv_30min_play = (ImageView) findViewById(R.id.iv_30min_play);
        iv_30min_reset = (ImageView) findViewById(R.id.iv_30min_reset);



        btn_5min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountDownTimer myCountDownTimer = new CountDownTimer(300000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {


                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        btn_5min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                        btn_5min.setEnabled(false);
                        iv_5min_play.setVisibility(View.GONE);
                        iv_5min_pause.setVisibility(View.VISIBLE);
                        iv_5min_reset.setVisibility(View.VISIBLE);
                    }


                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    @Override
                    public void onFinish() {
                        btn_5min.setText("05:00");
                        iv_5min_play.setVisibility(View.GONE);
                        iv_5min_pause.setVisibility(View.GONE);
                        btn_5min.setEnabled(true);



                    }


                }.start();



                iv_5min_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        iv_5min_play.setVisibility(View.VISIBLE);
                        iv_5min_reset.setVisibility(View.VISIBLE);
                        iv_5min_pause.setVisibility(View.GONE);


                    }
                });
                iv_5min_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        myCountDownTimer.onFinish();
                        iv_5min_reset.setVisibility(View.GONE);
                        btn_5min.setEnabled(true);


                    }
                });


                iv_5min_play.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String mint =  btn_5min.getText().toString();

                        String time = mint;

                        long min = Integer.parseInt(time.substring(0, 2));
                        long sec = Integer.parseInt(time.substring(3));

                        long t = (min * 60L) + sec;

                        long result = TimeUnit.SECONDS.toMillis(t);


                        final CountDownTimer myCountDownTimer = new CountDownTimer(result, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {


                                int time = (int) millisUntilFinished;
                                int seconds = time / 1000 % 60;
                                int minutes = (time / (1000 * 60)) % 60;
                                btn_5min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                                btn_5min.setEnabled(false);
                                iv_5min_play.setVisibility(View.GONE);
                                iv_5min_pause.setVisibility(View.VISIBLE);
                                iv_5min_reset.setVisibility(View.VISIBLE);
                            }


                            private String twoDigitString(long number) {
                                if (number == 0) {
                                    return "00";
                                } else if (number / 10 == 0) {
                                    return "0" + number;
                                }
                                return String.valueOf(number);
                            }
                            @Override
                            public void onFinish() {
                                btn_5min.setText("05:00");
                                iv_5min_play.setVisibility(View.GONE);
                                iv_5min_pause.setVisibility(View.GONE);
                                btn_5min.setEnabled(true);
                            }


                        }.start();

                        iv_5min_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                iv_5min_play.setVisibility(View.VISIBLE);
                                iv_5min_reset.setVisibility(View.VISIBLE);
                                iv_5min_pause.setVisibility(View.GONE);

                            }
                        });
                        iv_5min_reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                myCountDownTimer.onFinish();
                                iv_5min_reset.setVisibility(View.GONE);
                                btn_5min.setEnabled(true);



                            }
                        });

                    }
                });




            }
        });




        btn_10min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountDownTimer myCountDownTimer = new CountDownTimer(600000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        btn_10min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                        btn_10min.setEnabled(false);
                        iv_10min_play.setVisibility(View.GONE);
                        iv_10min_pause.setVisibility(View.VISIBLE);
                        iv_10min_reset.setVisibility(View.VISIBLE);
                    }


                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    @Override
                    public void onFinish() {
                        btn_10min.setText("10:00");
                        iv_10min_play.setVisibility(View.GONE);
                        iv_10min_pause.setVisibility(View.GONE);
                        btn_10min.setEnabled(true);



                    }


                }.start();



                iv_10min_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        iv_10min_play.setVisibility(View.VISIBLE);
                        iv_10min_reset.setVisibility(View.VISIBLE);
                        iv_10min_pause.setVisibility(View.GONE);


                    }
                });
                iv_10min_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        myCountDownTimer.onFinish();
                        iv_10min_reset.setVisibility(View.GONE);
                        btn_10min.setEnabled(true);


                    }
                });


                iv_10min_play.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String mint =  btn_10min.getText().toString();

                        String time = mint;

                        long min = Integer.parseInt(time.substring(0, 2));
                        long sec = Integer.parseInt(time.substring(3));

                        long t = (min * 60L) + sec;

                        long result = TimeUnit.SECONDS.toMillis(t);


                        final CountDownTimer myCountDownTimer = new CountDownTimer(result, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {


                                int time = (int) millisUntilFinished;
                                int seconds = time / 1000 % 60;
                                int minutes = (time / (1000 * 60)) % 60;
                                btn_10min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                                btn_10min.setEnabled(false);
                                iv_10min_play.setVisibility(View.GONE);
                                iv_10min_pause.setVisibility(View.VISIBLE);
                                iv_10min_reset.setVisibility(View.VISIBLE);
                            }


                            private String twoDigitString(long number) {
                                if (number == 0) {
                                    return "00";
                                } else if (number / 10 == 0) {
                                    return "0" + number;
                                }
                                return String.valueOf(number);
                            }
                            @Override
                            public void onFinish() {
                                btn_10min.setText("10:00");
                                iv_10min_play.setVisibility(View.GONE);
                                iv_10min_pause.setVisibility(View.GONE);
                                btn_10min.setEnabled(true);
                            }


                        }.start();

                        iv_10min_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                iv_10min_play.setVisibility(View.VISIBLE);
                                iv_10min_reset.setVisibility(View.VISIBLE);
                                iv_10min_pause.setVisibility(View.GONE);

                            }
                        });
                        iv_10min_reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                myCountDownTimer.onFinish();
                                iv_10min_reset.setVisibility(View.GONE);
                                btn_10min.setEnabled(true);



                            }
                        });

                    }
                });




            }
        });


        btn_15min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountDownTimer myCountDownTimer = new CountDownTimer(900000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {


                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        btn_15min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                        btn_15min.setEnabled(false);
                        iv_15min_play.setVisibility(View.GONE);
                        iv_15min_pause.setVisibility(View.VISIBLE);
                        iv_15min_reset.setVisibility(View.VISIBLE);
                    }


                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    @Override
                    public void onFinish() {
                        btn_15min.setText("15:00");
                        iv_15min_play.setVisibility(View.GONE);
                        iv_15min_pause.setVisibility(View.GONE);
                        btn_15min.setEnabled(true);



                    }


                }.start();



                iv_15min_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        iv_15min_play.setVisibility(View.VISIBLE);
                        iv_15min_reset.setVisibility(View.VISIBLE);
                        iv_15min_pause.setVisibility(View.GONE);


                    }
                });
                iv_15min_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        myCountDownTimer.onFinish();
                        iv_15min_reset.setVisibility(View.GONE);
                        btn_15min.setEnabled(true);


                    }
                });


                iv_15min_play.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String mint =  btn_15min.getText().toString();

                        String time = mint;

                        long min = Integer.parseInt(time.substring(0, 2));
                        long sec = Integer.parseInt(time.substring(3));

                        long t = (min * 60L) + sec;

                        long result = TimeUnit.SECONDS.toMillis(t);


                        final CountDownTimer myCountDownTimer = new CountDownTimer(result, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {


                                int time = (int) millisUntilFinished;
                                int seconds = time / 1000 % 60;
                                int minutes = (time / (1000 * 60)) % 60;
                                btn_15min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                                btn_15min.setEnabled(false);
                                iv_15min_play.setVisibility(View.GONE);
                                iv_15min_pause.setVisibility(View.VISIBLE);
                                iv_15min_reset.setVisibility(View.VISIBLE);
                            }


                            private String twoDigitString(long number) {
                                if (number == 0) {
                                    return "00";
                                } else if (number / 10 == 0) {
                                    return "0" + number;
                                }
                                return String.valueOf(number);
                            }
                            @Override
                            public void onFinish() {
                                btn_15min.setText("15:00");
                                iv_15min_play.setVisibility(View.GONE);
                                iv_15min_pause.setVisibility(View.GONE);
                                btn_15min.setEnabled(true);
                            }


                        }.start();

                        iv_15min_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                iv_15min_play.setVisibility(View.VISIBLE);
                                iv_15min_reset.setVisibility(View.VISIBLE);
                                iv_15min_pause.setVisibility(View.GONE);

                            }
                        });
                        iv_15min_reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                myCountDownTimer.onFinish();
                                iv_15min_reset.setVisibility(View.GONE);
                                btn_15min.setEnabled(true);



                            }
                        });

                    }
                });




            }
        });

        btn_20min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountDownTimer myCountDownTimer = new CountDownTimer((long) 1.2e+6, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {


                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        btn_20min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                        btn_20min.setEnabled(false);
                        iv_20min_play.setVisibility(View.GONE);
                        iv_20min_pause.setVisibility(View.VISIBLE);
                        iv_20min_reset.setVisibility(View.VISIBLE);
                    }


                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    @Override
                    public void onFinish() {
                        btn_20min.setText("20:00");
                        iv_20min_play.setVisibility(View.GONE);
                        iv_20min_pause.setVisibility(View.GONE);
                        btn_20min.setEnabled(true);



                    }


                }.start();



                iv_20min_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        iv_20min_play.setVisibility(View.VISIBLE);
                        iv_20min_reset.setVisibility(View.VISIBLE);
                        iv_20min_pause.setVisibility(View.GONE);


                    }
                });
                iv_20min_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        myCountDownTimer.onFinish();
                        iv_20min_reset.setVisibility(View.GONE);
                        btn_20min.setEnabled(true);


                    }
                });


                iv_20min_play.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String mint =  btn_20min.getText().toString();

                        String time = mint;

                        long min = Integer.parseInt(time.substring(0, 2));
                        long sec = Integer.parseInt(time.substring(3));

                        long t = (min * 60L) + sec;

                        long result = TimeUnit.SECONDS.toMillis(t);


                        final CountDownTimer myCountDownTimer = new CountDownTimer(result, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {


                                int time = (int) millisUntilFinished;
                                int seconds = time / 1000 % 60;
                                int minutes = (time / (1000 * 60)) % 60;
                                btn_20min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                                btn_20min.setEnabled(false);
                                iv_20min_play.setVisibility(View.GONE);
                                iv_20min_pause.setVisibility(View.VISIBLE);
                                iv_20min_reset.setVisibility(View.VISIBLE);
                            }


                            private String twoDigitString(long number) {
                                if (number == 0) {
                                    return "00";
                                } else if (number / 10 == 0) {
                                    return "0" + number;
                                }
                                return String.valueOf(number);
                            }
                            @Override
                            public void onFinish() {
                                btn_20min.setText("20:00");
                                iv_20min_play.setVisibility(View.GONE);
                                iv_20min_pause.setVisibility(View.GONE);
                                btn_20min.setEnabled(true);
                            }


                        }.start();

                        iv_20min_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                iv_20min_play.setVisibility(View.VISIBLE);
                                iv_20min_reset.setVisibility(View.VISIBLE);
                                iv_20min_pause.setVisibility(View.GONE);

                            }
                        });
                        iv_20min_reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                myCountDownTimer.onFinish();
                                iv_20min_reset.setVisibility(View.GONE);
                                btn_20min.setEnabled(true);



                            }
                        });

                    }
                });




            }
        });


        btn_25min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountDownTimer myCountDownTimer = new CountDownTimer((long) 1.5e+6, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {


                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        btn_25min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                        btn_25min.setEnabled(false);
                        iv_25min_play.setVisibility(View.GONE);
                        iv_25min_pause.setVisibility(View.VISIBLE);
                        iv_25min_reset.setVisibility(View.VISIBLE);
                    }


                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    @Override
                    public void onFinish() {
                        btn_25min.setText("25:00");
                        iv_25min_play.setVisibility(View.GONE);
                        iv_25min_pause.setVisibility(View.GONE);
                        btn_25min.setEnabled(true);



                    }


                }.start();



                iv_25min_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        iv_25min_play.setVisibility(View.VISIBLE);
                        iv_25min_reset.setVisibility(View.VISIBLE);
                        iv_25min_pause.setVisibility(View.GONE);


                    }
                });
                iv_25min_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        myCountDownTimer.onFinish();
                        iv_25min_reset.setVisibility(View.GONE);
                        btn_25min.setEnabled(true);


                    }
                });


                iv_25min_play.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String mint =  btn_25min.getText().toString();

                        String time = mint;

                        long min = Integer.parseInt(time.substring(0, 2));
                        long sec = Integer.parseInt(time.substring(3));

                        long t = (min * 60L) + sec;

                        long result = TimeUnit.SECONDS.toMillis(t);


                        final CountDownTimer myCountDownTimer = new CountDownTimer(result, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {


                                int time = (int) millisUntilFinished;
                                int seconds = time / 1000 % 60;
                                int minutes = (time / (1000 * 60)) % 60;
                                btn_25min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                                btn_25min.setEnabled(false);
                                iv_25min_play.setVisibility(View.GONE);
                                iv_25min_pause.setVisibility(View.VISIBLE);
                                iv_25min_reset.setVisibility(View.VISIBLE);
                            }


                            private String twoDigitString(long number) {
                                if (number == 0) {
                                    return "00";
                                } else if (number / 10 == 0) {
                                    return "0" + number;
                                }
                                return String.valueOf(number);
                            }
                            @Override
                            public void onFinish() {
                                btn_25min.setText("25:00");
                                iv_25min_play.setVisibility(View.GONE);
                                iv_25min_pause.setVisibility(View.GONE);
                                btn_25min.setEnabled(true);
                            }


                        }.start();

                        iv_25min_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                iv_25min_play.setVisibility(View.VISIBLE);
                                iv_25min_reset.setVisibility(View.VISIBLE);
                                iv_25min_pause.setVisibility(View.GONE);

                            }
                        });
                        iv_25min_reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                myCountDownTimer.onFinish();
                                iv_25min_reset.setVisibility(View.GONE);
                                btn_25min.setEnabled(true);



                            }
                        });

                    }
                });




            }
        });



        btn_30min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CountDownTimer myCountDownTimer = new CountDownTimer((long) 1.8e+6, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        int time = (int) millisUntilFinished;
                        int seconds = time / 1000 % 60;
                        int minutes = (time / (1000 * 60)) % 60;
                        btn_30min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                        btn_30min.setEnabled(false);
                        iv_30min_play.setVisibility(View.GONE);
                        iv_30min_pause.setVisibility(View.VISIBLE);
                        iv_30min_reset.setVisibility(View.VISIBLE);
                    }


                    private String twoDigitString(long number) {
                        if (number == 0) {
                            return "00";
                        } else if (number / 10 == 0) {
                            return "0" + number;
                        }
                        return String.valueOf(number);
                    }
                    @Override
                    public void onFinish() {
                        btn_30min.setText("30:00");
                        iv_30min_play.setVisibility(View.GONE);
                        iv_30min_pause.setVisibility(View.GONE);
                        btn_30min.setEnabled(true);



                    }


                }.start();



                iv_30min_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        iv_30min_play.setVisibility(View.VISIBLE);
                        iv_30min_reset.setVisibility(View.VISIBLE);
                        iv_30min_pause.setVisibility(View.GONE);


                    }
                });
                iv_30min_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myCountDownTimer.cancel();
                        myCountDownTimer.onFinish();
                        iv_30min_reset.setVisibility(View.GONE);
                        btn_30min.setEnabled(true);


                    }
                });


                iv_30min_play.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        String mint =  btn_30min.getText().toString();

                        String time = mint;

                        long min = Integer.parseInt(time.substring(0, 2));
                        long sec = Integer.parseInt(time.substring(3));

                        long t = (min * 60L) + sec;

                        long result = TimeUnit.SECONDS.toMillis(t);


                        final CountDownTimer myCountDownTimer = new CountDownTimer(result, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {


                                int time = (int) millisUntilFinished;
                                int seconds = time / 1000 % 60;
                                int minutes = (time / (1000 * 60)) % 60;
                                btn_30min.setText(twoDigitString(minutes) +":"+ twoDigitString(seconds));
                                btn_30min.setEnabled(false);
                                iv_30min_play.setVisibility(View.GONE);
                                iv_30min_pause.setVisibility(View.VISIBLE);
                                iv_30min_reset.setVisibility(View.VISIBLE);
                            }


                            private String twoDigitString(long number) {
                                if (number == 0) {
                                    return "00";
                                } else if (number / 10 == 0) {
                                    return "0" + number;
                                }
                                return String.valueOf(number);
                            }
                            @Override
                            public void onFinish() {
                                btn_30min.setText("30:00");
                                iv_30min_play.setVisibility(View.GONE);
                                iv_30min_pause.setVisibility(View.GONE);
                                btn_30min.setEnabled(true);
                            }


                        }.start();

                        iv_30min_pause.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                iv_30min_play.setVisibility(View.VISIBLE);
                                iv_30min_reset.setVisibility(View.VISIBLE);
                                iv_30min_pause.setVisibility(View.GONE);

                            }
                        });
                        iv_30min_reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                myCountDownTimer.cancel();
                                myCountDownTimer.onFinish();
                                iv_30min_reset.setVisibility(View.GONE);
                                btn_30min.setEnabled(true);



                            }
                        });

                    }
                });




            }
        });

    }

}