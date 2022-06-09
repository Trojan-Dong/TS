package rpc.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class RpcResponse {
    private String message;
}
