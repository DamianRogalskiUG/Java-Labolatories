public class Walec {
    private double promienPodstawy;
    private double wysokosc;
    public void setPromienPodstawy(double promienPodstawy) {
        this.promienPodstawy = promienPodstawy;
    }
    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }
    public double getPromienPodstawy() {
        return promienPodstawy;
    }
    public double getWysokosc() {
        return wysokosc;
    }
    public Walec(double promienPodstawy, double wysokosc) {
        this.promienPodstawy = promienPodstawy;
        this.wysokosc = wysokosc;
    }
    public Walec() {
    }
    public double obliczPolePodstawy() {
        return Math.PI * Math.pow(promienPodstawy, 2);
    }
    public double obliczPoleBoczne() {
        return 2 * Math.PI * promienPodstawy * wysokosc;
    }
    public double obliczPoleCalkowite() {
        return 2 * obliczPolePodstawy() + obliczPoleBoczne();
    }
    public double obliczObjetosc() {
        return obliczPolePodstawy() * wysokosc;
    }
}
