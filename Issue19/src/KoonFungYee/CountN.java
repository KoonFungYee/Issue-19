package KoonFungYee;

import java.util.concurrent.Callable;

public class CountN implements Callable {
    private static int countN = 0;

    @Override
    public Integer call() throws Exception {

        for (int i=199;i<Issue19.characters.size();i++){
            if (Issue19.characters.get(i).getCharacter()=='N'){
                countN++;
            }
        }

        return countN;
    }
}
