package cz.crypto.portfolio.service;

import cz.crypto.portfolio.model.Crypto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {
    List<Crypto> cryptos = new ArrayList<>();
    public int numberOfSameIds;

    public void uniquenessCheckOfId(Crypto crypto) {
        numberOfSameIds = 0;
        for (Crypto cryptoItem : cryptos) {
            if (crypto.getId() == cryptoItem.getId()) {
                numberOfSameIds = numberOfSameIds + 1;
            }
        }
        if (numberOfSameIds == 0){
            cryptos.add(crypto);
        }
    }

    public List<Crypto> getCryptos() {
        return cryptos;
    }

    public void sortingCryptosByNames() {
        cryptos.sort(Comparator.comparing(Crypto::getName));
    }

    public void sortingCryptosByPrice() {
        cryptos.sort(Comparator.comparing(Crypto::getPrice));
    }

    public void sortingCryptosByQuantity() {
        cryptos.sort(Comparator.comparing(Crypto::getQuantity));
    }

    public List<Crypto> sortingList(String sort){
        if (sort.equals("price")){
            sortingCryptosByPrice();
        }
        if (sort.equals("name")){
            sortingCryptosByNames();
        }
        if (sort.equals("quantity")){
            sortingCryptosByQuantity();
        }
        return cryptos;
    }

    public List<Crypto> findingCryptoById(String id){
        List<Crypto> newCrypto = new ArrayList<>();
        for (Crypto crypto : cryptos) {
            if ((String.valueOf(crypto.getId()).equals(id))) {
                newCrypto.add(crypto);
            }
        }
        return newCrypto;
    }

    public void settingDataOfCryptoById(String id, Crypto cryptoData){
        for (Crypto crypto : cryptos) {
            if ((String.valueOf(crypto.getId()).equals(id))) {
                crypto.setName(cryptoData.getName());
                crypto.setSymbol(cryptoData.getSymbol());
                crypto.setPrice(cryptoData.getPrice());
                crypto.setQuantity(cryptoData.getQuantity());
            }
        }
    }

    public double PortfolioValue() {
        double sum = 0;
        for (Crypto crypto : cryptos) {
            sum = sum + crypto.getPrice()*crypto.getQuantity();
        }
        return sum;
    }

    public void removeAllCryptos(){
        cryptos.clear();
    }

}//
