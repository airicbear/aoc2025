package org.example.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

class GiftShopTest {
    @ParameterizedTest
    @MethodSource("provideIdRanges")
    public void getInvalidIds_givenIdRange_returnsInvalidIds(String idRange, List<String> expectedInvalidIds) {
        // Arrange
        GiftShop giftShop = new GiftShop();

        // Act
        List<String> invalidIds = giftShop.getInvalidIds(idRange);

        // Assert
        assertThat(invalidIds).containsExactlyElementsOf(expectedInvalidIds);
    }

    @ParameterizedTest
    @MethodSource("provideManyIds")
    public void sumIds_givenManyIds_returnsExpectedSum(String manyIds, long expectedSum) {
        // Arrange
        GiftShop giftShop = new GiftShop();

        // Act
        long sum = giftShop.sumIds(giftShop.getManyInvalidIds(manyIds));

        // Assert
        assertThat(sum).isEqualTo(expectedSum);
    }

    static Stream<Arguments> provideIdRanges() {
        return Stream.of(
                        Arguments.of("11-22", List.of("11", "22")),
                    Arguments.of("95-115", List.of("99")),Arguments.of("998-1012", List.of("1010")),
        Arguments.of("1188511880-1188511890", List.of("1188511885")),
            Arguments.of("222220-222224", List.of("222222"))
                         );
    }

    static Stream<Arguments> provideManyIds() {
        return Stream.of(
                         Arguments.of("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124", 1227775554L),
                         Arguments.of("197-407,262128-339499,557930-573266,25-57,92856246-93001520,2-12,1919108745-1919268183,48414903-48538379,38342224-38444598,483824-534754,1056-1771,4603696-4688732,75712519-75792205,20124-44038,714164-782292,4429019-4570680,9648251-9913729,6812551522-6812585188,58-134,881574-897488,648613-673853,5261723647-5261785283,60035-128980,9944818-10047126,857821365-857927915,206885-246173,1922-9652,424942-446151,408-1000", 19128774598L)
                         );
    }
}
