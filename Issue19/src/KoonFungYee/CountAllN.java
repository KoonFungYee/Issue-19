package KoonFungYee;

import java.util.concurrent.Callable;

public class CountAllN implements Callable {
    private static int countAllN = 0;

    @Override
    public Integer call() throws Exception {
        for (int i=0;i<Issue19.characters.size();i++){
            if (Issue19.characters.get(i).getCharacter()=='N'){
                countAllN++;
            }
        }

        return countAllN;
    }
}
