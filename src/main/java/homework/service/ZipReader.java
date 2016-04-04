package homework.service;

import homework.model.FileRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by admin on 4/2/16.
 */
public class ZipReader {
    private ZipInputStream input;
    private List<FileRecord> res;
    public ZipReader(InputStream is) {
        this.input = new ZipInputStream(is);
    }
    public List<FileRecord> getData() throws IOException{
        this.res = new ArrayList<FileRecord>();
        ZipEntry ze = this.input.getNextEntry();
        while (ze != null) {
            if(!ze.isDirectory()) {
                byte b[] = new byte[(int)ze.getSize()];
                this.input.read(b);
                this.readRecords(ze.getName(), new String(b));
            }
            ze = this.input.getNextEntry();
        }
        Collections.sort(res);
        return res;
    }

    private void readRecords(String fname, String data) {
        String ss[] = data.split("(\r\n?)|\n");
        for(String s : ss) {
            if (!s.isEmpty()) {
                this.res.add(new FileRecord(s, fname));
            }
        }
    }
}
