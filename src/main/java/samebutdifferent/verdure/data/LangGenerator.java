package samebutdifferent.verdure.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureItems;

import java.util.function.Supplier;

public class LangGenerator extends LanguageProvider {
    public LangGenerator(DataGenerator gen, String locale) {
        super(gen, Verdure.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + Verdure.MOD_ID, "Verdure");
        for (RegistryObject<Item> item : VerdureItems.ITEMS.getEntries()) {
            addItem(item, formatId(item));
        }
    }

    private String formatId(RegistryObject object) {
        return WordUtils.capitalize(object.getId().getPath().replace("_", " "));
    }

    public void addEntitySoundEvents(String key, String name, String ambientSoundWord) {
        add(Verdure.MOD_ID + ".subtitles." + key + ".ambient", name + " " + ambientSoundWord);
        add(Verdure.MOD_ID + ".subtitles." + key + ".death", name + " dies");
        add(Verdure.MOD_ID + ".subtitles." + key + ".hurt", name + " hurts");
    }

    public void addSoundEvent(Supplier<? extends SoundEvent> key, String subtitle) {
        add(Verdure.MOD_ID + ".subtitles." + key.get().getLocation().getPath(), subtitle);
    }
}
