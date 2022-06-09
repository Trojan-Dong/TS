package rpc.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class RpcRequest {
    private String interfaceName;
    private String methodName;
}
