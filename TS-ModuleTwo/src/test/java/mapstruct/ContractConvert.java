package mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
    @Mapping(target = "id", ignore = true)
    TargetObject convert(SourceObject sourceObject);

//    @Mappings({
//            @Mapping(target = "quotaCode", source = "quotaCode", defaultExpression = "java(mapstruct.Test.getQuotaCode())"),
//            @Mapping(target = "id",expression ="java(mapstruct.Test.getId(id))" )
//    })
//    @Mapping(target = "id", ignore = true)
    List<TargetObject> convertList(List<SourceObject> list);

}
