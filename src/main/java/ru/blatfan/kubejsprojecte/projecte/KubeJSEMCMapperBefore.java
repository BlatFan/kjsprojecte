package ru.blatfan.kubejsprojecte.projecte;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import moze_intel.projecte.api.mapper.EMCMapper;
import moze_intel.projecte.api.mapper.IEMCMapper;
import moze_intel.projecte.api.mapper.collector.IMappingCollector;
import moze_intel.projecte.api.nss.NormalizedSimpleStack;
import moze_intel.projecte.emc.json.NSSSerializer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.ReloadableServerResources;
import net.minecraft.server.packs.resources.ResourceManager;

import java.util.HashMap;
import java.util.Map;

@EMCMapper(
        priority = 1000
)
public class KubeJSEMCMapperBefore implements IEMCMapper<NormalizedSimpleStack, Long> {
    @EMCMapper.Instance
    public static final KubeJSEMCMapperBefore INSTANCE = new KubeJSEMCMapperBefore();

    @Override
    public String getName() {
        return "KubeJSProjectE";
    }

    @Override
    public String getDescription() {
        return "Allows KubeJS ProjectE to function";
    }
    
    public Map<String, Long> items = new HashMap<>();
    
    @Override
    public void addMappings(IMappingCollector<NormalizedSimpleStack, Long> iMappingCollector, CommentedFileConfig commentedFileConfig, ReloadableServerResources reloadableServerResources, RegistryAccess registryAccess, ResourceManager resourceManager) {
        for (var entry : items.entrySet())
            iMappingCollector.setValueBefore(NSSSerializer.INSTANCE.deserialize(entry.getKey()), entry.getValue());
    }
}
