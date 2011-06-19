package org.nuntius.client;

import java.util.List;

import org.nuntius.provider.MyMessages.Messages;

import android.database.Cursor;
import android.os.Bundle;


/**
 * A plain text message.
 * Mime type: text/plain
 * @author Daniele Ricci
 * @version 1.0
 */
public class PlainTextMessage extends AbstractMessage<String> {
    //private static final String TAG = PlainTextMessage.class.getSimpleName();

    public static final String MIME_TYPE = "text/plain";

    protected PlainTextMessage() {
        super(null, null, null, null);
    }

    public PlainTextMessage(String id, String sender, byte[] content) {
        this(id, sender, content, null);
    }

    public PlainTextMessage(String id, String sender, byte[] content, List<String> group) {
        super(id, sender, MIME_TYPE, new String(content), group);
    }

    @Override
    public Bundle toBundle() {
        Bundle b = super.toBundle();
        b.putString(MSG_CONTENT, content);
        return b;
    }

    @Override
    protected void populateFromBundle(Bundle b) {
        super.populateFromBundle(b);
        content = b.getString(MSG_CONTENT);
    }

    @Override
    protected void populateFromCursor(Cursor c) {
        super.populateFromCursor(c);
        content = c.getString(c.getColumnIndex(Messages.CONTENT));
    }

    @Override
    public String getTextContent() {
        return content;
    }

    public static boolean supportsMimeType(String mime) {
        return MIME_TYPE.equalsIgnoreCase(mime);
    }

}
