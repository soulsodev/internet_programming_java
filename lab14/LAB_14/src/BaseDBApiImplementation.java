import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.*;
import lombok.SneakyThrows;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class BaseDBApiImplementation {

    private static DbxClientV2 client = null;

    static void init() {
        final DbxRequestConfig config = DbxRequestConfig.newBuilder("LAB_14").build();
        client = new DbxClientV2(config, "qwBQPsod-8MAAAAAAAAAAf3bK48kJRcyfGt-LSPb2MN8O8j4xMW-vNMdiiY56L2-");
    }

    @SneakyThrows
    static void createDirectory(final String dirName) throws DbxException {
        final CreateFolderResult folderResult = client.files().createFolderV2(dirName);
    }

    @SneakyThrows
    static void download(final String path) throws DbxException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DbxDownloader<FileMetadata> downloader = client.files().download(path);

        try {
            downloader.download(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            downloader.close();
        }

        Metadata actual = downloader.getResult();
        System.out.println(actual.getName());

    }

    @SneakyThrows
    static void upload(final String from, final String to) throws IOException, DbxException {
        final FileInputStream is = new FileInputStream(from);
        client.files().uploadBuilder(to).withMode(WriteMode.ADD).uploadAndFinish(is);
    }

    @SneakyThrows
    static void copyFile(final String from, final String to) throws DbxException {
        client.files().copyV2(from, to);
    }

    @SneakyThrows
    static  void delete(final String path) throws DbxException {
        client.files().deleteV2(path);
    }
}
