package main.java.nestedlists;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Task {

    public static void main(String[] args) {
        Map<String, BigDecimal> map = new HashMap<>();
        UsersAssets usersAssets = initialize();
        
        usersAssets.usersAssets.stream()
                .map(userAssets -> userAssets.assets)
                .flatMap(assets -> assets.stream())
                .forEach(asset -> {
                    String word = asset.word;
                    BigDecimal value = asset.value;
                    if (map.containsKey(word)) {
                        map.put(word, value.add(map.get(word)));
                    } else {
                        map.put(word, value);
                    }
                });

        System.out.println(map);

        Optional<Map.Entry<String, BigDecimal>> maxEntry = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        maxEntry.ifPresent(entry ->
                System.out.println(String.format("Word = %s, value = %f", entry.getKey(), entry.getValue())));
    }


    private record Asset(String word, BigDecimal value) {
    }

    private static class UserAssets {
        String user;
        List<Asset> assets;

        private UserAssets(UserAssetsBuilder builder) {
            this.user = builder.userName;
            this.assets = builder.listOfAssets;
        }

        public String getUser() {
            return user;
        }

        public List<Asset> getAssets() {
            return assets;
        }

        //Builder pattern for structured initialization
        private static class UserAssetsBuilder {
            private String userName;
            private List<Asset> listOfAssets;

            public UserAssetsBuilder() {}

            public UserAssetsBuilder userName(String userName) {
                this.userName = userName;
                return this;
            }

            public UserAssetsBuilder assetsList(List<Asset> listOfAssets) {
                this.listOfAssets = listOfAssets;
                return this;
            }

            public UserAssets build() {
                return new UserAssets(this);
            }
        }
    }

    private static class UsersAssets {
        List<UserAssets> usersAssets;

        public UsersAssets(List<UserAssets> usersAssets) {
            this.usersAssets = usersAssets;
        }
    }

    private static UsersAssets initialize() {

                UsersAssets usersAssetsLists = new UsersAssets(List.of(
                        new UserAssets.UserAssetsBuilder()
                                .userName("John")
                                .assetsList(List.of(
                                        new Asset("AAA", BigDecimal.valueOf(25)),
                                        new Asset("BBB", BigDecimal.valueOf(10)),
                                        new Asset("CCC", BigDecimal.valueOf(5))
                                )).build(),
                        new UserAssets.UserAssetsBuilder()
                                .userName("Mary")
                                .assetsList(List.of(
                                        new Asset("AAA", BigDecimal.valueOf(30)),
                                        new Asset("BBB", BigDecimal.valueOf(15))
                                )).build(),
                        new UserAssets.UserAssetsBuilder()
                                .userName("Susan")
                                .assetsList(List.of(
                                        new Asset("DDD", BigDecimal.valueOf(45))
                                )).build()
        ));

        return usersAssetsLists;
    }

}
