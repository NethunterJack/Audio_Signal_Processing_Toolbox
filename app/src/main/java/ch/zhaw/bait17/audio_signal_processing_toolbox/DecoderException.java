package ch.zhaw.bait17.audio_signal_processing_toolbox;

/**
 * Created by georgrem, stockan1 on 16.02.2017.
 */

public class DecoderException extends Exception {

    private String message = null;

    public DecoderException() {
        super();
    }

    public DecoderException(String message) {
        super(message);
        this.message = message;
    }

    public DecoderException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public DecoderException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

}