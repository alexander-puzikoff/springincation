package com.puzikov.util.exception;

import java.io.IOException;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>07/18/2016</pre>
 */
public class ImageUploadException extends RuntimeException{
    public ImageUploadException(String s) {
        super(s);

    }

    public ImageUploadException(Throwable e) {
        super(e);
    }
}
