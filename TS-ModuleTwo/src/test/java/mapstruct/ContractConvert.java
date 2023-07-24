package mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ContractConvertFactory.class)
public interface ContractConvert {
    
    ContractConvert INSTANCE = Mappers.getMapper(ContractConvert.class);
    
    
    //    @Mappings({
    //            @Mapping(target = "quotaCode", source = "quotaCode", defaultExpression = "java(mapstruct.Test
    //            .getQuotaCode())"),
    //            @Mapping(target = "id",expression = "java(null)")
    //    })
    @Mapping(target = "id", expression = "java(null)")
    TargetObject convert(SourceObject quotaCode);
    
//    @Mappings({
//            @Mapping(target = "quotaCode", source = "quotaCode", defaultExpression = "java(mapstruct.Test.getQuotaCode())"),
//            @Mapping(target = "id",expression ="java(mapstruct.Test.getId(id))" )
//    })
    List<TargetObject> convertList(List<SourceObject> list);
    
}
