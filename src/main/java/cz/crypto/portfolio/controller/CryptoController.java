package cz.crypto.portfolio.controller;

import cz.crypto.portfolio.model.Crypto;
import cz.crypto.portfolio.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cryptos")
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    //Nebo klasicky:
    //CryptoService cryptoService = new CryptoService();

    //Kryptoměny pro ověření funkčnosti kódu (zadání přes Postman v JSON
    //v příslušném formátu dat):
    //public void fillCryptos(CryptoService cryptoService){
    //    cryptos.add(new Crypto(1, "Bitcoin", "BTC", 99788.68, 5));
    //    cryptos.add(new Crypto(2, "Ethereum", "ETH", 3980.26, 6));
    //    cryptos.add(new Crypto(3, "Solana", "SOL", 238.33, 11));
    //    cryptos.add(new Crypto(4, "XRP", "XRP", 2.54, 21));
    //    cryptos.add(new Crypto(5, "Tether", "USDT", 1.00, 25));
    //    cryptos.add(new Crypto(6, "BNB", "BNB", 755.67, 8));
    //}

    @PostMapping()
    public ResponseEntity<?> addOneCryptoInList(@RequestBody Crypto crypto){
        cryptoService.uniquenessCheckOfId(crypto);
        if (cryptoService.numberOfSameIds > 0){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Warning! " +
                    "A cryptocurrency with that Id already exists in the list!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("OK. " +
                    "The cryptocurrency has been successfully added to the list.");
    }

    @GetMapping()
    public List<Crypto> getAllCryptosInList(){
        return cryptoService.getCryptos();
    }

    @GetMapping("/cryptos")
    public List<Crypto> sortCryptos(@RequestParam String sort) {
        return cryptoService.sortingList(sort);
    }

    @GetMapping("{id}")
    public List<Crypto> detailOfCrypto(@PathVariable String id) {
        return cryptoService.findingCryptoById(id);
    }

    @PutMapping("{id}")
    public void settingOfCryptoById(@PathVariable String id, @RequestBody Crypto cryptoData){
        cryptoService.settingDataOfCryptoById(id, cryptoData);
    }

    @GetMapping("/portfolio-value")
    public double valueOfPortfolio() {
        return cryptoService.PortfolioValue();
    }

    @DeleteMapping("/delete")
    public void deleteAllCryptos(){
        cryptoService.removeAllCryptos();
    }

}//konec třídy
