package UI;

public enum RabbitPose {
    SIMPLE("bsimple.png"),   // звичайна поза, курсор не над вікнами програми
    GOSSIP("bgossip.png"),   // вікно «Про авторку»
    TEACH("bteach.png"),     // вікно «Про метод»
    THINK("bthink.png");     // вікно введення тексту

    public final String file;

    RabbitPose(String file) {
        this.file = file;
    }
}