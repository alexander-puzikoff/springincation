package com.puzikov.domain;

import java.util.Date;

/**
 * @author APuzikov
 * @version 1.0
 * @since <pre>06/27/2016</pre>
 */
public class Spittle {
    private Spitter spitter;
    private Date when;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    static public class SpittleBuilder {
        private Spitter spitter;
        private String text;
        private Date when;

        public SpittleBuilder() {
        }

        public SpittleBuilder buildSpitter(Spitter spitter) {
            this.spitter = spitter;
            return this;
        }

        public SpittleBuilder buildText(String text) {
            this.text = text;
            return this;
        }

        public SpittleBuilder buildWhen(Date when) {
            this.when = when;
            return this;
        }

        public Spittle build() {
            Spittle spittle = new Spittle();
            spittle.setSpitter(this.spitter);
            spittle.setWhen(this.when);
            spittle.setText(this.text);
            return spittle;
        }
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

}
