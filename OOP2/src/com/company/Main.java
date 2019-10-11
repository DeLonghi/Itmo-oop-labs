package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            Genre Rock = new Genre("Rock");
            Composer Ozzy = new Composer("Ozzy", Rock);
            Album ToC = new Album("The Ozzman Cometh", Ozzy, 3, 1987);
            ToC.addTrack(new Track("Crazy Train"));
            ToC.addTrack(new Track("Miracle Man"));
            ToC.addTrack(new Track("Crazy Babies"));
//            ToC.showAlbum();

            Genre hardrock = new Genre("Hard Rock");
            Rock.addSubGenre(hardrock);
            Composer met = new Composer("Metallica", hardrock);
            Album MoP = new Album(("Master Of Puppets"), met, 3, 1987);
            MoP.addTrack(new Track("Battery"));
            MoP.addTrack(new Track("Orion"));
            MoP.addTrack(new Track("Damage"));
//            MoP.showAlbum();
            Catalog catalog = new Catalog();
//            catalog.searchGenre("Rock");

            Collection collection = new Collection("My stuff");
            collection.addAlbum(MoP);
            collection.addAlbum(ToC);
            collection.show();
            ToC.showAlbum();

        }
        catch (Exception e) {
        }
    }
}
