package br.com.conductor.retryexemplo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UsuarioService {


    @Autowired
    private RestTemplate restTemplate;

    @Retryable(value = {HttpClientErrorException.class})
    public void recuperarUsuarios(String cnpj){

        log.info("Executando o recuperar usuarios = {}", LocalDateTime.now());
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://www.mocky.io/v2/5b6dd3b4330000bb29a36f841x");
            ResponseEntity<String> retorno = restTemplate.exchange(builder.buildAndExpand().encode().toUri(),
                    HttpMethod.POST, null, String.class);
        }catch (HttpServerErrorException ex){
            throw ex;
        }catch (HttpClientErrorException ex){
            throw ex;
        }
    }

    @Recover
    private void recover(HttpClientErrorException ex){
        log.info("Entrou no recover, {}", ex.getMessage());
    }


//    @Recover
//    private void recover(HttpServerErrorException ex){
//        log.info("Entrou no recover 2, {}", ex.getMessage());
//    }
}
