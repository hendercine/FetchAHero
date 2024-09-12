package dev.jameshenderson.fetchahero.domain.useCases

interface UseCase<in Params, out Result> {
    suspend operator fun invoke(params: Params): Result
}
