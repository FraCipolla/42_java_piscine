package ex02;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Shell {
    private String _path = new String();
    private Scanner _input = new Scanner(System.in);

    public Shell(String path) { this.cd(path); }

    private void mv(String ori, String dest) {
        Path source = Paths.get(ori);
        Path target = Paths.get(dest);
        try {
            Files.move(source, target,
            StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ls() throws IOException {
        Path dir = Paths.get(this._path);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*")) {
            for (Path file : stream) {
                String path = file.toString();
                String[] split = path.split("/");
                final String print = split[split.length - 1];
                if (print.toCharArray()[0] != '.') {
                    System.out.println(print + " " + (Files.size(file) > 1000 ? Files.size(file) / 1000 + " KB" : Files.size(file) + " BYTES"));
                }
            }
        }
    }

    private void pwd() {
        System.out.println(System.getProperty("user.dir"));
    }

    private void cd(String path) {
        char[] arr = path.toCharArray();
        String fullPath = new String();

        if (path.startsWith("..")) {
            final String[] split = this._path.split("/");
            for (int i = 0; i < split.length - 1; i++) {
                fullPath += split[i] + "/";
            }
            if (path.length() > 2) {
                String[] getPath = path.split("/");
                for (int i = 1; i < getPath.length; i++) {
                    fullPath += getPath[i] + "/";
                }
            }
            System.out.println(fullPath);
        } else {
            fullPath = this._path + path;
        }
        if (!fullPath.endsWith("/")) {
            fullPath += "/";
        }
        System.setProperty("user.dir", fullPath);
        this._path = System.getProperty("user.dir");
    }

    public void loop() throws IOException {
        while (true) {
            System.out.print("-> ");
            String in = this._input.nextLine();
            String[] split = in.split(" ");
            if (split[0].equals("exit")) {
                break;
            } else if (split[0].equals("pwd")) {
                this.pwd();
            } else if (split[0].equals("ls")) {
                this.ls();
            }
            else if (split[0].equals("cd")) {
                this.cd(split[1]);
            } else if (split[0].equals("mv")) {
                this.mv(split[1], split[2]);
            }
        }
    }

}
