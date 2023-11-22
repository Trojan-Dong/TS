package mapstruct;

import java.util.ArrayList;
import java.util.List;

public class MapStructMain {

    public static void main(String[] args) {
        SourceObject sourceObject = new SourceObject();
        sourceObject.setQuotaCode("aaaa");
        sourceObject.setId(1L);
        SourceObject sourceObject1 = new SourceObject();
        sourceObject1.setQuotaCode("bbbb");
        sourceObject1.setId(2L);
        List<SourceObject> list = new ArrayList<>();
        list.add(sourceObject);
        list.add(sourceObject1);
        TargetObject obj = ContractConvert.INSTANCE.convert(sourceObject);
        List<TargetObject> targetObjects = ContractConvert.INSTANCE.convertList(list);

        targetObjects.forEach(targetObject -> {
            System.out.println(targetObject.getQuotaCode());
            System.out.println(targetObject.getId());
        });
    }


}
