package cloud.autotests.config.tochka;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/tochkamain/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();

}
