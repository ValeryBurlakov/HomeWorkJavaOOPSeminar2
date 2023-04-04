// import java.io.FileWriter;
// import java.io.IOException;

// public interface SaveFiles {
//     default void savefile(String string) {
//         try (FileWriter file = new FileWriter("newfile.txt")) {
//             file.append(string);

//         } catch (IOException e) {
//             throw new RuntimeException();
//         }
//     }
// }
