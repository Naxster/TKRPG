public class Item extends Thing {

    public Item(int c, String n) {
        this.cost = c;
        this.name = n;
        this.require = 0;
    }

    public String show() {
        String res = name;
        return res;
    }

    public ThingType id() {
        return ThingType.ITEM;
    }

    public void remove_from(Player z) {
    }

    public void add_to(Player z) {
        z.chgGOLD(this.cost);
    }
}