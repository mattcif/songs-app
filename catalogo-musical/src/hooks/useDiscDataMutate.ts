import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios"
import { DiscData } from '../interface/DiscData';

const API_URL = 'http://localhost:8080/api';

const postData = async (data: DiscData): AxiosPromise<unknown> => {
    const response = axios.post(API_URL + '/disc', data);
    return response;
}

export function useDiscDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries(['disc-data'])
        }
    })

    return mutate;
}